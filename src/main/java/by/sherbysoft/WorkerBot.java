package by.sherbysoft;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.GetChat;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetChatResponse;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;
import java.util.stream.Collectors;

public class WorkerBot {
    public static void main(String[] args) {

        TelegramBot bot = new TelegramBot("1401157875:AAH58s3ffNjH-B8WPX16SrVSJrUtkrET-4E");
        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {

                List<Update> updatesWithMessage = updates.stream().filter(u -> u != null && u.message() != null &&
                        u.message().text() != null).collect(Collectors.toList());

                boolean cleanCommandReceived = updatesWithMessage.stream().filter(u -> u != null && u.message() != null &&
                        u.message().text() != null)
                        .anyMatch(u -> u.message().text().equals("/clear"));

                if(cleanCommandReceived) {
                    for(Update update:updatesWithMessage) {
                        DeleteMessage deleteMessage = new DeleteMessage(update.message().chat().id(),
                                update.message().messageId());
                        bot.execute(deleteMessage);
                    }

                    return UpdatesListener.CONFIRMED_UPDATES_ALL;
                } else {
                    return UpdatesListener.CONFIRMED_UPDATES_NONE;
                }
            }
        });
    }
}
