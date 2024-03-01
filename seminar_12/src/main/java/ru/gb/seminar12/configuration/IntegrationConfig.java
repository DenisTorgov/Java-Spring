package ru.gb.seminar12.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {
    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel textOutputChanel() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileReadChanel() {
        return new DirectChannel();
    }
    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> {
    //какая-то логика
            return text;
        };
    }
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler (new File(
                        "C:/Users/Robotruten/gblessons/Java Spring/seminar_12/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }


//    @Bean
//    @InboundChannelAdapter(value = "fileReadChanel", poller = @Poller(fixedDelay = "1000"))
//    public MessageSource<File> fileReadingHandler() {
//        FileReadingMessageSource readingSource = new FileReadingMessageSource();
//        readingSource.setDirectory(new File(
//                "C:/Users/Robotruten/gblessons/Java Spring/seminar_12/files/"));
//        return readingSource;
//    }
//    @Bean
//    @Transformer(inputChannel = "fileReadChanel", outputChannel = "textOutputChanel")
//    public FileToStringTransformer fileToStringTransformer() {
//        return new FileToStringTransformer();
//    }
}
