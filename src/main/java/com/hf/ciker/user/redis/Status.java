package com.hf.ciker.user.redis;

import java.util.concurrent.TimeUnit;

/**
 * @author ciker
 * @version 1.0
 * @date 2020/6/8 21:10
 */
public interface Status {

    enum ExpireEnum{
        //未读消息的有效期为30天
        UNREAD_MSG(30L, TimeUnit.DAYS)
        ;

        /**
         * 过期时间
         */
        private Long time;
        /**
         * 时间单位
         */
        private TimeUnit timeUnit;

        ExpireEnum(Long time, TimeUnit timeUnit) {
            this.time = time;
            this.timeUnit = timeUnit;
        }

        public Long getTime() {
            return time;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }
    }
}
