package no.bekk.bekkyo.sms;

import android.telephony.SmsManager;
import android.telephony.SmsMessage;

import no.bekk.bekkyo.dto.EmployeeDto;

public class SMSService {
    public static void sendYo(EmployeeDto dto) {
        String phoneNumber = dto.getMobilePhone();
        String smsBody = "YO!";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, smsBody, null, null);
    }
}
