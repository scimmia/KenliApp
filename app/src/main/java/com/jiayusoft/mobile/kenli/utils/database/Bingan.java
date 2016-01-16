package com.jiayusoft.mobile.kenli.utils.database;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.jiayusoft.mobile.kenli.utils.Phrase;
import org.apache.commons.lang3.StringUtils;

/**
 * Entity mapped to table BINGAN.
 */
public class Bingan {

    private String biaoshima;
    private String binganhao;
    private String zuzhidaima;
    private String zuzhiname;
    private String fenzhijigoubiaosi;
    private String xingming;
    private String chuyuankeshi;
    private String chuyuanshijian;
    private String zhusu;
    private Boolean shoucang;
    private Boolean jieyue;
    private String baomijibie;

//    public Bingan() {
//    }

    public Bingan(String biaoshima) {
        this.biaoshima = biaoshima;
        String temp = "";
        this.binganhao = temp;
        this.zuzhidaima = temp;
        this.zuzhiname = temp;
        this.fenzhijigoubiaosi = temp;
        this.xingming = temp;
        this.chuyuankeshi = temp;
        this.chuyuanshijian = temp;
        this.zhusu = temp;
        this.shoucang = false;
        this.jieyue = false;
        this.baomijibie = null;
    }

    public Bingan(String biaoshima, String binganhao, String zuzhidaima, String zuzhiname, String fenzhijigoubiaosi, String xingming, String chuyuankeshi, String chuyuanshijian, String zhusu, Boolean shoucang, Boolean jieyue) {
        this.biaoshima = biaoshima;
        this.binganhao = binganhao;
        this.zuzhidaima = zuzhidaima;
        this.zuzhiname = zuzhiname;
        this.fenzhijigoubiaosi = fenzhijigoubiaosi;
        this.xingming = xingming;
        this.chuyuankeshi = chuyuankeshi;
        this.chuyuanshijian = chuyuanshijian;
        this.zhusu = zhusu;
        this.shoucang = shoucang;
        this.jieyue = jieyue;
    }

    public String getBiaoshima() {
        return biaoshima;
    }

    public void setBiaoshima(String biaoshima) {
        if (StringUtils.isNotEmpty(biaoshima))  this.biaoshima = biaoshima;
    }

    public String getBinganhao() {
        return binganhao;
    }

    public void setBinganhao(String binganhao) {
        if (StringUtils.isNotEmpty(binganhao))   this.binganhao = binganhao;
    }

    public String getZuzhidaima() {
        return zuzhidaima;
    }

    public void setZuzhidaima(String zuzhidaima) {
        if (StringUtils.isNotEmpty(zuzhidaima))
            this.zuzhidaima = zuzhidaima;
    }

    public String getZuzhiname() {
        return zuzhiname;
    }

    public void setZuzhiname(String zuzhiname) {
        if (StringUtils.isNotEmpty(zuzhiname))
            this.zuzhiname = zuzhiname;
    }

    public String getFenzhijigoubiaosi() {
        return fenzhijigoubiaosi;
    }

    public void setFenzhijigoubiaosi(String fenzhijigoubiaosi) {
        if (StringUtils.isNotEmpty(fenzhijigoubiaosi))
            this.fenzhijigoubiaosi = fenzhijigoubiaosi;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        if (StringUtils.isNotEmpty(xingming))    this.xingming = xingming;
    }

    public String getChuyuankeshi() {
        return chuyuankeshi;
    }

    public void setChuyuankeshi(String chuyuankeshi) {
        if (StringUtils.isNotEmpty(chuyuankeshi))     this.chuyuankeshi = chuyuankeshi;
    }

    public String getChuyuanshijian() {
        return chuyuanshijian;
    }

    public void setChuyuanshijian(String chuyuanshijian) {
        if (StringUtils.isNotEmpty(chuyuanshijian))     this.chuyuanshijian = chuyuanshijian;
    }


    public String getZhusu() {
        return zhusu;
    }

    public void setZhusu(String zhusu) {
        if (StringUtils.isNotEmpty(zhusu))     this.zhusu = zhusu;
    }

    public CharSequence getText() {

        CharSequence formatted = Phrase.from(getTemplate())
                .put("binganid", binganhao)
                .put("xingming", xingming)
                .put("chuyuankeshi", chuyuankeshi)
//                .put("zhusu", zhusu)
                .put("chuyuanshijian", chuyuanshijian)
                .format();
        return formatted;
    }
    public CharSequence getBorrowText() {

        CharSequence formatted = Phrase.from(getBorrowTemplate())
                .put("binganid", binganhao)
                .put("xingming", xingming)
                .put("zuzhiname", zuzhiname)
                .put("chuyuankeshi", chuyuankeshi)
                .put("chuyuanshijian", chuyuanshijian)
                .format();
        return formatted;
    }
    public Boolean getShoucang() {
        return shoucang;
    }

    public void setShoucang(Boolean shoucang) {
        this.shoucang = shoucang;
    }

    public Boolean getJieyue() {
        return jieyue;
    }

    public void setJieyue(Boolean jieyue) {
        this.jieyue = jieyue;
    }

    public String getBaomijibie() {
        return baomijibie;
    }

    public void setBaomijibie(String baomijibie) {
        this.baomijibie = baomijibie;
    }

    static SpannableStringBuilder template;
    static SpannableStringBuilder getTemplate(){
//        if (template == null){
//            int color = Color.parseColor("#FFFF536F");
//            template = new SpannableStringBuilder (
//                    "病案号: {binganid}\n姓名: {xingming}\n出院科室: {chuyuankeshi}\n主诉: {zhusu}\n出院日期: {chuyuanshijian} ");
//            template.setSpan(new ForegroundColorSpan(color), 5, 15, 0);
//            template.setSpan(new ForegroundColorSpan(color), 20, 30, 0);
//            template.setSpan(new ForegroundColorSpan(color), 37, 51, 0);
//            template.setSpan(new ForegroundColorSpan(color), 56, 63, 0);
//            template.setSpan(new ForegroundColorSpan(color), 70, 86, 0);
//        }
        if (template == null){
            int color = Color.parseColor("#FFffffff");
            template = new SpannableStringBuilder(
                    "姓名: {xingming}\t病案号: {binganid}\n出院科室: {chuyuankeshi}\n出院日期: {chuyuanshijian}");
            template.setSpan(new ForegroundColorSpan(color), 4, 14, 0);
            template.setSpan(new ForegroundColorSpan(color), 20, 30, 0);
            template.setSpan(new ForegroundColorSpan(color), 37, 51, 0);
            template.setSpan(new ForegroundColorSpan(color), 58, 74, 0);
        }
        return template;
    }
    static SpannableStringBuilder getBorrowTemplate(){
        int color = Color.parseColor("#FFffffff");
        SpannableStringBuilder borrowtemplate = new SpannableStringBuilder(
                "姓名: {xingming}\t病案号: {binganid}\n所属机构: {zuzhiname}\n出院科室: {chuyuankeshi}\n出院日期: {chuyuanshijian} ");
        borrowtemplate.setSpan(new ForegroundColorSpan(color), 4, 14, 0);
        borrowtemplate.setSpan(new ForegroundColorSpan(color), 20, 30, 0);
        borrowtemplate.setSpan(new ForegroundColorSpan(color), 37, 48, 0);
        borrowtemplate.setSpan(new ForegroundColorSpan(color), 55, 69, 0);
        borrowtemplate.setSpan(new ForegroundColorSpan(color), 76, 92, 0);
        return borrowtemplate;
    }
}
