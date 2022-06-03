package com.wf.domain;

import org.springframework.http.StreamingHttpOutputMessage;

import java.util.Date;

/*
* VO: View Object  ���ֲ�����ڱ��ֲ����ǰ̨����
* */
public class CourseVO {
    //����
    private Integer id;

    //�γ�����
    private String courseName;

    //�γ�һ�仰���
    private String brief;

    //ԭ��
    private double price;

    //ԭ�۱�ǩ
    private String priceTag;

    //�Żݼ�
    private double discounts;

    //�Żݼ۱�ǩ
    private String discountsTag;

    //�γ�����markdown
    private String courseDescriptionMarkDown;

    //�γ�����
    private String courseDescription;

    //�γ̷���ͼƬurl
    private String courseImgUrl;

    //�Ƿ���Ʒ
    private int isNew;

    //�����
    private String isNewDes;

    //��������
    private int lastOperatorId;



    //�Ƿ�ɾ��
    private int isDel;

    //��ʱ��
    private int totalDuration;

    //�γ��б�չʾͼƬ
    private String courseListImg;

    //�γ�״̬��0-�ݸ壬1-�ϼ�
    private int status;

    //�γ�����
    private int sortNum;

    //�γ�Ԥ����һ���ֶ�
    private String previewFirstField;

    //�γ�Ԥ���ڶ����ֶ�
    private String previewSecondField;

    private Integer sales;

    //��ʦ��Ϣ
    //��ʦ����
    private String teacherName;
    //��ʦְλ
    private String position;
    //��ʦ����
    private String description;

    @Override
    public String toString() {
        return "CourseVO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", brief='" + brief + '\'' +
                ", price=" + price +
                ", priceTag='" + priceTag + '\'' +
                ", discounts=" + discounts +
                ", discountsTag='" + discountsTag + '\'' +
                ", courseDescriptionMarkDown='" + courseDescriptionMarkDown + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseImgUrl='" + courseImgUrl + '\'' +
                ", isNew=" + isNew +
                ", isNewDes='" + isNewDes + '\'' +
                ", lastOperatorId=" + lastOperatorId +
                ", isDel=" + isDel +
                ", totalDuration=" + totalDuration +
                ", courseListImg='" + courseListImg + '\'' +
                ", status=" + status +
                ", sortNum=" + sortNum +
                ", previewFirstField='" + previewFirstField + '\'' +
                ", previewSecondField='" + previewSecondField + '\'' +
                ", sales=" + sales +
                ", teacherName='" + teacherName + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(String priceTag) {
        this.priceTag = priceTag;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public String getDiscountsTag() {
        return discountsTag;
    }

    public void setDiscountsTag(String discountsTag) {
        this.discountsTag = discountsTag;
    }

    public String getCourseDescriptionMarkDown() {
        return courseDescriptionMarkDown;
    }

    public void setCourseDescriptionMarkDown(String courseDescriptionMarkDown) {
        this.courseDescriptionMarkDown = courseDescriptionMarkDown;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public String getIsNewDes() {
        return isNewDes;
    }

    public void setIsNewDes(String isNewDes) {
        this.isNewDes = isNewDes;
    }

    public int getLastOperatorId() {
        return lastOperatorId;
    }

    public void setLastOperatorId(int lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getCourseListImg() {
        return courseListImg;
    }

    public void setCourseListImg(String courseListImg) {
        this.courseListImg = courseListImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public String getPreviewFirstField() {
        return previewFirstField;
    }

    public void setPreviewFirstField(String previewFirstField) {
        this.previewFirstField = previewFirstField;
    }

    public String getPreviewSecondField() {
        return previewSecondField;
    }

    public void setPreviewSecondField(String previewSecondField) {
        this.previewSecondField = previewSecondField;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
