
// MFCBinaryTreeDlg.h : ���� ���������
//

#pragma once


// ���������� ���� CMFCBinaryTreeDlg
class CMFCBinaryTreeDlg : public CDialogEx
{
// ��������
public:
	CImageList m_imageList;
	CMFCBinaryTreeDlg(CWnd* pParent = NULL);	// ����������� �����������

// ������ ����������� ����
	enum { IDD = IDD_MFCBINARYTREE_DIALOG };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// ��������� DDX/DDV


// ����������
protected:
	HICON m_hIcon;

	// ��������� ������� ����� ���������
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
};
