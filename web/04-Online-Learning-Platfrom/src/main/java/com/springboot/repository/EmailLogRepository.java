package com.springboot.repository;

import com.springboot.entity.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailLogRepository  extends JpaRepository<EmailLog, Long> {

}