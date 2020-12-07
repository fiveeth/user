package com.gyh.usercenter.rocketmq;

import com.gyh.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.gyh.usercenter.domain.entity.bonusEventLog.BonusEventLog;
import com.gyh.usercenter.domain.entity.user.User;
import com.gyh.usercenter.mapper.bonusEventLog.BonusEventLogMapper;
import com.gyh.usercenter.mapper.user.UserMapper;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cncoder
 */
@Component
@RocketMQMessageListener(consumerGroup = "consumer-group", topic = "add-bonus")
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        //添加积分
        User user = userMapper.selectByPrimaryKey(userAddBonusMsgDTO.getUserId());
        Integer bonus = userAddBonusMsgDTO.getBonus();
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKeySelective(user);
        //记录日志到bonus_event_log表
        BonusEventLog bonusEventLog = new BonusEventLog();
        bonusEventLog.setUserId(userAddBonusMsgDTO.getUserId());
        bonusEventLog.setValue(bonus);
        bonusEventLog.setEvent("CONTRIBUTE");
        bonusEventLog.setCreateTime(new Date());
        bonusEventLog.setDescription("投稿加积分");
        bonusEventLogMapper.insert(bonusEventLog);
    }
}
