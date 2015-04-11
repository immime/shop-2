package com.lingxiang2014.service;

import java.util.List;
import java.util.Map;

import com.lingxiang2014.entity.SafeKey;

public interface MailService {

    void send(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername, String smtpPassword, String toMail, String subject, String templatePath, Map<String, Object> model, boolean async, List<String> attachments);

    void send(String toMail, String subject, String templatePath, Map<String, Object> model, boolean async);

    void send(String toMail, String subject, String templatePath, Map<String, Object> model);

    void send(String toMail, String subject, String templatePath);

    void sendTestMail(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername, String smtpPassword, String toMail);

    void sendFindPasswordMail(String toMail, String username, SafeKey safeKey);

    public void sendBackupMail(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername, String smtpPassword, String toMail,List<String> attachments);

}