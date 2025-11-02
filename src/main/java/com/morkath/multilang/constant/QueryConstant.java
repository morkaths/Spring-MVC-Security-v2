package com.morkath.multilang.constant;

public class QueryConstant {
  public static final String FIND_BY_USERNAME_OR_EMAIL =
      "SELECT u FROM AuthUserEntity u " +
      "LEFT JOIN FETCH u.roles r " +
      "LEFT JOIN FETCH r.permissions " +
      "WHERE (u.username = :identifier OR u.email = :identifier) AND u.status = " + SystemConstant.ACTIVE_STATUS;
}
