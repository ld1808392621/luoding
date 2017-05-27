package com.luoding.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;
import sun.print.resources.serviceui_zh_TW;

import java.util.Set;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-12-20 下午10:27
 */
public class ZsetTest {

    public static void main(String [] args){


   /*     final JedisPool jedisPool = new JedisPool("192.168.14.48",6379);
        Jedis jedis = jedisPool.getResource();
        *//*jedis.zadd("ztest",1,"one");
        jedis.zadd("ztest",2,"two");
        jedis.zadd("ztest",4,"four");
        jedis.zadd("ztest",5,"five");
        jedis.zadd("ztest",6,"six");*//*

        Set<String> sets = jedis.zrangeByScore("ztest",1,2);
        System.out.println(sets);
        jedis.close();
        jedisPool.close();*/
        String s = "{\"amount\":\"45009.0\",\"cancelTime\":\"2017-01-18 11:46:12\",\"channel\":\"luoding wap\",\"contactName\":\"JIANG\\/JUN\",\"delivery\":\"noDispatch\",\"deviceId\":\"F6B5A898-D944-418D-A877-760CB183C23E\",\"email\":\"lesley630@hotmail.com\",\"ip\":\"223.102.243.236\",\"isInternational\":true,\"member\":\"13910394333\",\"orderId\":\"102904931\",\"orderState\":\"E\",\"orderStateTime\":\"2017-01-18 11:57:00\",\"phone\":\"13910394333\",\"quantity\":\"3\",\"scheduledTime\":\"2017-01-18 11:31:12\",\"seatCount\":\"6\",\"subchannel\":\"ios\",\"travelers\":[{\"arrivalCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"arrivalTime\":\"2017-02-01 22:15:00\",\"cabinClass\":\"F\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU5706\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G45694263\",\"passengerName\":\"JIANGJUN\",\"startCity\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"startTime\":\"2017-02-01 18:30:00\",\"ticket\":\"441031865\",\"type\":\"2\",\"passengerAttribution\":\"G45694263\",\"passengerCountry\":\"G45694263\",\"passengerProvince\":\"G45694263\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGJUN2017-02-01\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"arrivalTime\":\"2017-02-01 22:15:00\",\"cabinClass\":\"F\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU5706\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G55301717\",\"passengerName\":\"LIUSHANYUAN\",\"startCity\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"startTime\":\"2017-02-01 18:30:00\",\"ticket\":\"551699229\",\"type\":\"2\",\"passengerAttribution\":\"G55301717\",\"passengerCountry\":\"G55301717\",\"passengerProvince\":\"G55301717\",\"passengerFamilyName1\":\"L\",\"passengerFamilyName2\":\"LI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"LIUSHANYUAN2017-02-01\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"arrivalTime\":\"2017-02-01 22:15:00\",\"cabinClass\":\"F\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU5706\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"E49270896\",\"passengerName\":\"JIANGXIAOJUN\",\"startCity\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"startTime\":\"2017-02-01 18:30:00\",\"ticket\":\"733850388\",\"type\":\"2\",\"passengerAttribution\":\"E49270896\",\"passengerCountry\":\"E49270896\",\"passengerProvince\":\"E49270896\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGXIAOJUN2017-02-01\"},{\"arrivalCity\":\"\\u6fb3\\u5927\\u5229\\u4e9a\\u6089\\u5c3c\",\"arrivalTime\":\"2017-02-02 14:45:00\",\"cabinClass\":\"I\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU777\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G45694263\",\"passengerName\":\"JIANGJUN\",\"startCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"startTime\":\"2017-02-02 00:50:00\",\"ticket\":\"243135487\",\"type\":\"2\",\"passengerAttribution\":\"G45694263\",\"passengerCountry\":\"G45694263\",\"passengerProvince\":\"G45694263\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGJUN2017-02-02\"},{\"arrivalCity\":\"\\u6fb3\\u5927\\u5229\\u4e9a\\u6089\\u5c3c\",\"arrivalTime\":\"2017-02-02 14:45:00\",\"cabinClass\":\"I\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU777\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G55301717\",\"passengerName\":\"LIUSHANYUAN\",\"startCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"startTime\":\"2017-02-02 00:50:00\",\"ticket\":\"128503707\",\"type\":\"2\",\"passengerAttribution\":\"G55301717\",\"passengerCountry\":\"G55301717\",\"passengerProvince\":\"G55301717\",\"passengerFamilyName1\":\"L\",\"passengerFamilyName2\":\"LI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"LIUSHANYUAN2017-02-02\"},{\"arrivalCity\":\"\\u6fb3\\u5927\\u5229\\u4e9a\\u6089\\u5c3c\",\"arrivalTime\":\"2017-02-02 14:45:00\",\"cabinClass\":\"I\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU777\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"E49270896\",\"passengerName\":\"JIANGXIAOJUN\",\"startCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"startTime\":\"2017-02-02 00:50:00\",\"ticket\":\"700173059\",\"type\":\"2\",\"passengerAttribution\":\"E49270896\",\"passengerCountry\":\"E49270896\",\"passengerProvince\":\"E49270896\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGXIAOJUN2017-02-02\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"arrivalTime\":\"2017-02-10 05:35:00\",\"cabinClass\":\"I\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU778\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G45694263\",\"passengerName\":\"JIANGJUN\",\"startCity\":\"\\u6fb3\\u5927\\u5229\\u4e9a\\u6089\\u5c3c\",\"startTime\":\"2017-02-09 21:50:00\",\"ticket\":\"446959041\",\"type\":\"2\",\"passengerAttribution\":\"G45694263\",\"passengerCountry\":\"G45694263\",\"passengerProvince\":\"G45694263\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGJUN2017-02-09\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"arrivalTime\":\"2017-02-10 05:35:00\",\"cabinClass\":\"I\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU778\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G55301717\",\"passengerName\":\"LIUSHANYUAN\",\"startCity\":\"\\u6fb3\\u5927\\u5229\\u4e9a\\u6089\\u5c3c\",\"startTime\":\"2017-02-09 21:50:00\",\"ticket\":\"229806997\",\"type\":\"2\",\"passengerAttribution\":\"G55301717\",\"passengerCountry\":\"G55301717\",\"passengerProvince\":\"G55301717\",\"passengerFamilyName1\":\"L\",\"passengerFamilyName2\":\"LI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"LIUSHANYUAN2017-02-09\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"arrivalTime\":\"2017-02-10 05:35:00\",\"cabinClass\":\"I\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU778\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"E49270896\",\"passengerName\":\"JIANGXIAOJUN\",\"startCity\":\"\\u6fb3\\u5927\\u5229\\u4e9a\\u6089\\u5c3c\",\"startTime\":\"2017-02-09 21:50:00\",\"ticket\":\"401694699\",\"type\":\"2\",\"passengerAttribution\":\"E49270896\",\"passengerCountry\":\"E49270896\",\"passengerProvince\":\"E49270896\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGXIAOJUN2017-02-09\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"arrivalTime\":\"2017-02-10 11:45:00\",\"cabinClass\":\"F\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU5713\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G45694263\",\"passengerName\":\"JIANGJUN\",\"startCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"startTime\":\"2017-02-10 08:25:00\",\"ticket\":\"103333437\",\"type\":\"2\",\"passengerAttribution\":\"G45694263\",\"passengerCountry\":\"G45694263\",\"passengerProvince\":\"G45694263\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGJUN2017-02-10\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"arrivalTime\":\"2017-02-10 11:45:00\",\"cabinClass\":\"F\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU5713\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"G55301717\",\"passengerName\":\"LIUSHANYUAN\",\"startCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"startTime\":\"2017-02-10 08:25:00\",\"ticket\":\"621011151\",\"type\":\"2\",\"passengerAttribution\":\"G55301717\",\"passengerCountry\":\"G55301717\",\"passengerProvince\":\"G55301717\",\"passengerFamilyName1\":\"L\",\"passengerFamilyName2\":\"LI\",\"passengerPassportCountry\":[\"Cambodia\",\"China\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"LIUSHANYUAN2017-02-10\"},{\"arrivalCity\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"arrivalTime\":\"2017-02-10 11:45:00\",\"cabinClass\":\"F\",\"certificateType\":\"4\",\"flightCompany\":\"MU\",\"flightNo\":\"MU5713\",\"merchantId\":\"CTRIP\",\"passengerCardId\":\"E49270896\",\"passengerName\":\"JIANGXIAOJUN\",\"startCity\":\"\\u4e2d\\u56fd\\u4e91\\u5357\\u7701\\u6606\\u660e\\u5e02\",\"startTime\":\"2017-02-10 08:25:00\",\"ticket\":\"701712743\",\"type\":\"2\",\"passengerAttribution\":\"E49270896\",\"passengerCountry\":\"E49270896\",\"passengerProvince\":\"E49270896\",\"passengerFamilyName1\":\"J\",\"passengerFamilyName2\":\"JI\",\"passengerPassportCountry\":[\"Cambodia\",\"Georgia\",\"Germany\",\"Iran\",\"Macau (China)\",\"Malaysia\",\"Mexico\",\"Montenegro\",\"Netherlands\",\"Nigeria\",\"Turkey\",\"UAE\"],\"passengerNameStartTime\":\"JIANGXIAOJUN2017-02-10\"}],\"currentDataType\":\"unknow\",\"registeredPhone\":\"13910394333\",\"registeredTime\":\"2008-12-16 00:15:04\",\"memberName\":\"\\u5218\\u59d7\\u5a9b\",\"ipAttribution\":\"\\u4e2d\\u56fd\\u8fbd\\u5b81\\u7701\\u8fbd\\u9633\\u5e02\",\"ipCountry\":\"\\u4e2d\\u56fd\",\"ipContinent\":\"Asia\",\"ipProvince\":\"\\u8fbd\\u5b81\\u7701\",\"ipCity\":\"\\u8fbd\\u9633\",\"phoneTop10\":\"1391039433\",\"phoneAttribution\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"phoneCountry\":\"\\u4e2d\\u56fd\",\"phoneProvince\":\"\\u5317\\u4eac\\u5e02\",\"phoneCity\":false,\"registeredPhoneAttribution\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\",\"paymentType\":\"creditCard\",\"creditCardRiskLevel\":0,\"cardIdRiskLevel\":0,\"passengerRiskLevel\":0,\"cardHolderRiskLevel\":0,\"creditCardRiskLevelDetail\":\"\",\"cardIdRiskLevelDetail\":\"\",\"cards\":[{\"creditCard\":\"09oN2opnExIc77H9xNfJufuG\\/smXI4e8\",\"cardHolder\":\"\\u5218\\u59d7\\u5a9b\",\"cardHolderType\":\"0\",\"cardHolderCardId\":\"NKCQGS6jmRCWMy7h+8YtxU+qpj3q2\\/Mp\",\"creditCardLifetime\":\"2021-01-01\",\"creditBank\":\"\\u62db\\u5546\\u94f6\\u884c\",\"isWildCard\":0,\"paymentTime\":\"2017-01-18 11:34:42\",\"cardHolderAttribution\":\"\\u4e2d\\u56fd\\u8fbd\\u5b81\\u7701\\u8fbd\\u9633\\u5e02\",\"cardHolderCountry\":\"\\u4e2d\\u56fd\",\"cardHolderProvince\":\"\\u8fbd\\u5b81\\u7701\",\"cardHolderCity\":\"\\u8fbd\\u9633\"}]}\t";
        System.out.println(s.length());
    }
}
