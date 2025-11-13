package com.morkath.multilang.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dto.AuthUserDTO;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.repository.AuthRoleRepository;
import com.morkath.multilang.repository.AuthUserRepository;
import com.morkath.multilang.service.UserService;
import com.morkath.multilang.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AuthUserRepository userRepository;

	@Autowired
	private AuthRoleRepository roleRepository;

	@Override
	public List<AuthUserDTO> getAllUsers() {
		return userRepository.findAll().stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public AuthUserDTO getUserById(Long id) {
		return userRepository.findById(id)
				.map(this::toDTO)
				.orElse(null);
	}

	@Override
	public AuthUserDTO getUserByUsername(String username) {
		AuthUserEntity user = userRepository.findByUsername(username);
		return user != null ? toDTO(user) : null;
	}

	@Override
	public AuthUserDTO createUser(AuthUserDTO userDTO) {
		AuthUserEntity user = new AuthUserEntity();
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(PasswordUtil.hash(userDTO.getPassword()));
		user.setStatus(userDTO.getStatus());
		if (userDTO.getRoleIds() != null && !userDTO.getRoleIds().isEmpty()) {
			user.setRoles(new HashSet<>(roleRepository.findAllById(userDTO.getRoleIds())));
		}
		AuthUserEntity saved = userRepository.save(user);
		return toDTO(saved);
	}

	@Override
	public AuthUserDTO updateUser(AuthUserDTO userDTO) {
		AuthUserEntity user = userRepository.findById(userDTO.getId()).orElse(null);
		if (user != null) {
			user.setUsername(userDTO.getUsername());
			user.setEmail(userDTO.getEmail());
			user.setPassword(PasswordUtil.hash(userDTO.getPassword()));
			user.setStatus(userDTO.getStatus());
			if (userDTO.getRoleIds() != null) {
				user.setRoles(new HashSet<>(roleRepository.findAllById(userDTO.getRoleIds())));
			}
			AuthUserEntity saved = userRepository.save(user);
			return toDTO(saved);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public AuthUserDTO getCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		AuthUserEntity user = userRepository.findByUsername(username);
		return user != null ? toDTO(user) : null;
	}

	private AuthUserDTO toDTO(AuthUserEntity entity) {
		AuthUserDTO dto = new AuthUserDTO();
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setStatus(entity.getStatus());
		if (entity.getRoles() != null) {
			dto.setRoleIds(entity.getRoles().stream().map(role -> role.getId()).collect(Collectors.toSet()));
		}
		return dto;
	}
}