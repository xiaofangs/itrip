package cn.itrip.auth.service.impl;

import cn.itrip.auth.service.MailService;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("MailService")
public class MailServiceImpl implements MailService {
    @Resource
    private SimpleMailMessage mailMessage;
    @Resource
    private MailSender mailSender;
    @Override
    public void sendActivationMail(String mailTo, String activationCode) {
        mailMessage.setTo(mailTo);
        mailMessage.setText("你的激活码是"+activationCode);
        mailSender.send(mailMessage);
    }
}
