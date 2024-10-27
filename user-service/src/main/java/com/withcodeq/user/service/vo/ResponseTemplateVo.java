package com.withcodeq.user.service.vo;

import com.withcodeq.user.service.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVo {
    private Users users;
    private Department department;
}
