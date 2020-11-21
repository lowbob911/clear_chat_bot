package by.sherbysoft;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetChat;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetChatResponse;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

public class WorkerBot {
    public static void main(String[] args) {
//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(new ClearChatBot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }

        TelegramBot bot = new TelegramBot("1401157875:AAH58s3ffNjH-B8WPX16SrVSJrUtkrET-4E");
        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {

                System.out.println(updates.size());

                return UpdatesListener.CONFIRMED_UPDATES_NONE;
            }
        });
    }
}
