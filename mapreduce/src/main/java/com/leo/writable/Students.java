package com.leo.writable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Students implements Writable {
    // 学号
    private String stuID;
    // 姓名
    private String stuName;
    // 年龄
    private int stuAge;
    // 数学成绩
    private int mathScore;
    // 语文成绩
    private int chineseScore;
    // 英语成绩
    private int englishScore;

    public Students() {
    }

    public Students(String stuID, String stuName, int stuAge, int mathScore, int chineseScore, int englishScore) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.mathScore = mathScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    // 序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(stuID);
        dataOutput.writeUTF(stuName);
        dataOutput.writeInt(stuAge);
        dataOutput.writeInt(mathScore);
        dataOutput.writeInt(mathScore);
        dataOutput.writeInt(mathScore);
    }

    // 反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.stuID = dataInput.readUTF();
        this.stuName = dataInput.readUTF();
        this.stuAge = dataInput.readInt();
        this.mathScore = dataInput.readInt();
        this.chineseScore = dataInput.readInt();
        this.englishScore = dataInput.readInt();
    }
    // 按需，重写toString


    @Override
    public String toString() {
        return "Students{" +
                "stuID='" + stuID + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", mathScore=" + mathScore +
                ", chineseScore=" + chineseScore +
                ", englishScore=" + englishScore +
                '}';
    }
}
