package com.estafet.training.kafkaProject.dao.mapper;

import com.estafet.training.kafkaProject.model.Payments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentsMapper implements RowMapper<Payments> {

        public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {
            Payments Payments = new Payments();
            Payments.setPaymentId(rs.getString("paymentid"));
            Payments.setTimestamp(rs.getString("timestamp"));
            Payments.setAmount(rs.getFloat("amount"));
            Payments.setCurrency(rs.getString("currency"));
            Payments.setSenderName(rs.getString("sendername"));
            Payments.setSenderIBAN(rs.getString("senderiban"));
            Payments.setReceiverName(rs.getString("receivername"));
            Payments.setReceiverIBAN(rs.getString("receiveriban"));
            return Payments;

        }


    }
