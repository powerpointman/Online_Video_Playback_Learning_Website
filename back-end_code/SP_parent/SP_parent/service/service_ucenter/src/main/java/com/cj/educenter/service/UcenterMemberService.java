package com.cj.educenter.service;

import com.cj.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-04-05
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember member);

    void register(RegisterVo registerVo);
}
