package JavaList;
//�������ǵ�������
class Node
{
	private String data;//����ڵ�����
	private Node next;//��ʾ������һ���ڵ�
	
	public Node(String data)
	{
		this.data = data;
	}
	public void setNext(Node next)
	{
		this.next = next;//������һ���ڵ�
	}
	public Node getNext()//ȡ����һ���ڵ�
	{
		return this.next;
	}
	
	public String getData()
	{
		return this.data;//ȡ�ýڵ�����
	}
};
public class JavaListPro
{
	public static void printNode(Node node)//����ڵ�
	{
		System.out.print(node.getData()+"\t");
		if(node.getNext() != null)//�жϴ˽ڵ��Ƿ������һ���ڵ�
		{
			printNode(node.getNext());//���¼������
		}
	}
	
	public static void main(String[] args)
	{
		Node root = new Node("��ͷ");//������ڵ�
		Node n1 = new Node("����-A");//�����һ�����ᣨ��һ���ڵ㣩
		Node n2 = new Node("����-B");//�����һ�����ᣨ�ڶ����ڵ㣩
		Node n3 = new Node("����-C");//�����һ�����ᣨ�������ڵ㣩
		
		root.setNext(n1);//���û�ͷ���¸��ڵ��ǵ�һ������A
		n1.setNext(n2);//���õ�һ���������һ���ڵ��ǵڶ�������
		n2.setNext(n3);//���õڶ����������һ���ڵ��ǵ���������
		printNode(root);//��ͷ��ʼ���
		
		//020518_����5�£�������������_ʵ�����⡪��������2��

	}

}
