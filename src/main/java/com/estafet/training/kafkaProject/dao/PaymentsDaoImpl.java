package com.estafet.training.kafkaProject.dao;

import com.estafet.training.kafkaProject.model.Payments;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//@Slf4j


@Repository
public class PaymentsDaoImpl implements PaymentsDao {

    public PaymentsDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

  //  @Autowired
 //   NamedParameterJdbcTemplate namedParamJdbcTemplate;

    @Override
    public void insertPayments(Payments payments) {

        SqlParameterSource paramSource = new MapSqlParameterSource(
                getMapForPayments(payments));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update("INSERT INTO payments("
                        + " paymentid, timestamp, amount, currency, sendername, senderiban, receivername, receiveriban )"
                        + " VALUES (:paymentid, :timestamp, :amount, :currency, :sendername, :senderiban, :receivername, :receiveriban )",
                paramSource, keyHolder);
     }


    private Map<String, Object> getMapForPayments(Payments payments){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("paymentid", payments.getPaymentId());
        map.put("timestamp", payments.getTimestamp());
        map.put("amount", payments.getAmount());
        map.put("currency", payments.getCurrency());
        map.put("sendername", payments.getSenderName());
        map.put("senderiban", payments.getSenderIBAN());
        map.put("receivername", payments.getReceiverName());
        map.put("receiveriban", payments.getReceiverIBAN());
        return map;
    }


}
