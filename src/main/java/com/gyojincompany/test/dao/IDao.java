package com.gyojincompany.test.dao;

import java.util.ArrayList;

import com.gyojincompany.test.dto.MemberDto;

public interface IDao {
	public void memberJoin(String mid, String mpw, String mname, String memail);
	public ArrayList<MemberDto> memberList();//��� ȸ�� ����Ʈ ��������(������ ��� ��������)
	public MemberDto searchIdOk(String mid);//ȸ�� ���̵�� �˻��Ͽ� 1�� ������ ��������
}
