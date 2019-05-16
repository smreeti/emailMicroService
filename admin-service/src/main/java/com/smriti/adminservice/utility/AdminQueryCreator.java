package com.smriti.adminservice.utility;

import java.util.function.Supplier;

public class AdminQueryCreator {

    public static Supplier<String> createQueryToFetchAdminsToSendEmail = () ->
         " SELECT a.id, a.email_address FROM admin a WHERE a.email_sent = 'N'";
}
