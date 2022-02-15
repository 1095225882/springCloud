package com.atguigu.springcloud.sercice;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    boolean create(Payment payment);

    Payment getPaymentById(Long id);
}
