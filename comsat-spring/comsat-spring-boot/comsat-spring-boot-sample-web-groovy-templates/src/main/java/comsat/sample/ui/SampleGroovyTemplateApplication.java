/*
 * COMSAT
 * Copyright (c) 2013-2015, Parallel Universe Software Co. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 3.0
 * as published by the Free Software Foundation.
 */
/*
 * Based on the corresponding class in Spring Boot Samples.
 * Copyright the original author(s).
 * Released under the ASF 2.0 license.
 */
package comsat.sample.ui;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import co.paralleluniverse.springframework.boot.autoconfigure.web.FiberSpringBootApplication;
import org.springframework.boot.SpringApplication;

// snippet import
@FiberSpringBootApplication // This will enable fiber-blocking
// end of snippet
public class SampleGroovyTemplateApplication {
    @Bean
    public MessageRepository messageRepository() {
        return new InMemoryMessageRespository();
    }

    @Bean
    public Converter<String, Message> messageConverter() {
        return new Converter<String, Message>() {
            @Override
            public Message convert(String id) {
                return messageRepository().findMessage(Long.valueOf(id));
            }
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleGroovyTemplateApplication.class, args);
    }
}
