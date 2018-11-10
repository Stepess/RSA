package ua.assymcrypto;

import ua.assymcrypto.util.RadixUtil;

public class App
{
    public static void main( String[] args )
    {
        int i = 305445566;
        System.out.println(RadixUtil.decToHex(i));
    }
}
