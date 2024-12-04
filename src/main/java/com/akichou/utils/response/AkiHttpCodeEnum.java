package com.akichou.utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AkiHttpCodeEnum {

    SUCCESS(200, "操作成功"),
    CREATED(201, "已創建"),
    ACCEPTED(202, "已接受"),
    NO_CONTENT(204, "無內容"),

    BAD_REQUEST(400, "錯誤請求"),
    NEED_LOGIN(401, "需登入後才能操作"),
    NO_OPERATOR_AUTH(403, "無權限操作"),
    CONTENT_NOT_FOUND(404, "找不到目標內容"),
    METHOD_NOT_ALLOWED(405, "方法不允許"),

    INTERNAL_ERROR(500, "系統內部錯誤") ;

    private final int code ;
    private final String msg ;
}
