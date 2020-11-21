package by.sherbysoft;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ClearChatBot extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "true_clear_bot";
    }

    public String getBotToken() {
        return "1401157875:AAH58s3ffNjH-B8WPX16SrVSJrUtkrET-4E";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        System.out.println("test");
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
