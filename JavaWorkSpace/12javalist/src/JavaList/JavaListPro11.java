package JavaList;

//import JavaList.Link.Node;

//������������¼��ֲ������������ݡ��������ݡ�ɾ������

class LinkNew//����������
{
	
	class Node//����ÿһ���ڵ㣬�˴�Ϊ�˷���ֱ�Ӷ�����ڲ���
	{
		private String data;//����ڵ������
		private Node next;//������һ���ڵ�
		public Node(String data)
		{
			this.data = data;//ͨ�����췽�����ýڵ�����
		}
		
		public void add(Node newNode)//���ڵ���뵽���ʵ�λ��
		{
			if(this.next == null)//�����һ���ڵ�Ϊ�գ�����½ڵ�������next
			{
				this.next = newNode;
			}
			else//�����һ���ڵ㲻Ϊ�գ���������±�����next
			{
				this.next.add(newNode);
			}
			
		}
		public void  print()
		{
			System.out.print(this.data+"\t");
			if(this.next != null)// ������һ��Ԫ����Ҫ�������
			{
				this.next.print();//��һ���ڵ�������� print
			}
		}
		
		public boolean search(String data)//�ڲ������ķ���
		{
			if(data.equals(this.data))//�ж�����������Ƿ�͵�ǰ�ڵ������һ��
			{
				return true;
			}
			else
			{
				if(this.next != null)//��һ���ڵ�������ڣ����������
				{
					return this.next.search(data);//������һ���Ĳ�ѯ���
				}
				else
				{
					return false;//��������Ľڵ㶼��ѯ��ɺ�û�����ݣ��򷵻� false
				}
			}
		}
		public void delete(Node pre,String data)
		{
			if(data.equals(this.data))//�ҵ���ƥ��Ľڵ�
			{
				pre.next = this.next;//�ճ���ǰ�Ľڵ���
			}
			else
			{
				if(this.next != null)//���Ǵ�����һ���ڵ�
				{
					this.next.delete(this, data);//��������
				}
				
			}
		}
		
		
	};
	
	private Node root;//�����б�Ȼ����һ�����ڵ�
	public void addNode(String data)//���ӽڵ�
	{
		Node newNode = new Node(data);//�����µĽڵ�
		if(this.root == null)//û�и��ڵ�
		{
			this.root = newNode;//����һ���ڵ����óɸ��ڵ�
		}
		else//���Ǹ��ڵ㣬�ŵ����һ���ڵ�֮��
		{
			this.root.add(newNode);//ͨ��Node�Զ����Ŵ˽ڵ�ŵ�λ��
		}
	}
	public void printNode()// ���ȫ�����������
	{
		if(this.root != null)//�����Ԫ�ز�Ϊ��
		{
			this.root.print();//����Node���е��������
		}
	}
	
	public boolean look(String name)//�ж�Ԫ���Ƿ����
	{
		return this.root.search(name);//����Node���еĲ��ҷ���
	}
	public void deleteNode(String data)//ɾ���ڵ�
	{
		if(this.look(data))//�жϽڵ��Ƿ����
		{
			//һ��Ҫ�жϴ�Ԫ���ǲ��Ǹ�Ԫ����ȵ�//
			if(this.root.data.equals(data))//�����Ǹ��ڵ�
			{
				this.root = this.root.next;//�޸ĸ��ڵ㣬����һ���ڵ�����Ϊ���ڵ�
			}
			else
			{
				this.root.next.delete(root,data);//����һ���ڵ��ǰ�ڵ������һ������ȥ
			}
		}
	}
};


public class JavaListPro11
{

	public static void main(String[] args)
	{
		LinkNew lin = new LinkNew();
		lin.addNode("A");//���ӽڵ�
		lin.addNode("B");//���ӽڵ�
		lin.addNode("C");//���ӽڵ�
		lin.addNode("D");//���ӽڵ�
		lin.addNode("E");//���ӽڵ�
		
		System.out.println("=====����֮�������======");
		lin.printNode();
		
		System.out.println(" ");
		System.out.println("=====���Բ������ݣ�C======");
		System.out.println(lin.look("C"));//�鵽����true
		System.out.println(lin.look("X"));//�鲻������ false
		
		System.out.println(" ");
		System.out.println("=====ɾ��֮��======");
		lin.deleteNode("C");//ɾ���Ѵ��ڵĽڵ�
		lin.deleteNode("A");//ɾ�����ڵ�
		lin.deleteNode("R");//ɾ�������ڵĽڵ�
		lin.printNode();

	}

}
