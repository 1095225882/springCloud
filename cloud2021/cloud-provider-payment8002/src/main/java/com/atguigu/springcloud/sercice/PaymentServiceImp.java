package com.atguigu.springcloud.sercice;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public boolean create(Payment payment) {
        return paymentDao.create(payment) > 0;
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
