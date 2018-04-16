package chapter11;
import java.lang.reflect.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ProcessorTest
{
	public static void process(String clazz) throws SecurityException, ClassNotFoundException
		/*throws ClassNotFoundException*/
	{
		int passed = 0;
		int failed = 0;
		// ����clazz��Ӧ����������з���
		for (Method m : Class.forName(clazz).getMethods())
		{
			// ����÷���ʹ����@Testable����
			if (m.isAnnotationPresent(Testable.class))
			{
				try
				{
					// ����m����
					m.invoke(null);
					// ���Գɹ���passed��������1
					passed++;
				}
				catch (Exception ex)
				{
					System.out.println("����" + m + "����ʧ�ܣ��쳣��"
						+ ex.getCause());
					// ���Գ����쳣��failed��������1
					failed++;
				}
			}
		}
		// ͳ�Ʋ��Խ��
		System.out.println("��������:" + (passed + failed)
			+ "�����������У�\n" + "ʧ����:" + failed + "����\n"
			+ "�ɹ���:" + passed + "����");
	}
}

