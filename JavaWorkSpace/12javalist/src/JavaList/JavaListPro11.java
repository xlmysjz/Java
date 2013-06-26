package JavaList;

//import JavaList.Link.Node;

//对链表进行以下几种操作：增加数据、查找数据、删除数据

class LinkNew//链表的完成类
{
	
	class Node//保存每一个节点，此处为了方便直接定义成内部类
	{
		private String data;//保存节点的内容
		private Node next;//保存下一个节点
		public Node(String data)
		{
			this.data = data;//通过构造方法设置节点内容
		}
		
		public void add(Node newNode)//将节点加入到合适的位置
		{
			if(this.next == null)//如果下一个节点为空，则把新节点设置在next
			{
				this.next = newNode;
			}
			else//如果下一个节点不为空，则继续向下遍历找next
			{
				this.next.add(newNode);
			}
			
		}
		public void  print()
		{
			System.out.print(this.data+"\t");
			if(this.next != null)// 还有下一个元素需要继续输出
			{
				this.next.print();//下一个节点继续调用 print
			}
		}
		
		public boolean search(String data)//内部搜索的方法
		{
			if(data.equals(this.data))//判断输入的数据是否和当前节点的数据一致
			{
				return true;
			}
			else
			{
				if(this.next != null)//下一个节点如果存在，则继续查找
				{
					return this.next.search(data);//返回下一个的查询结果
				}
				else
				{
					return false;//如果所欲的节点都查询完成后没有内容，则返回 false
				}
			}
		}
		public void delete(Node pre,String data)
		{
			if(data.equals(this.data))//找到了匹配的节点
			{
				pre.next = this.next;//空出当前的节点来
			}
			else
			{
				if(this.next != null)//还是存在下一个节点
				{
					this.next.delete(this, data);//继续查找
				}
				
			}
		}
		
		
	};
	
	private Node root;//链表中必然存在一个根节点
	public void addNode(String data)//增加节点
	{
		Node newNode = new Node(data);//定义新的节点
		if(this.root == null)//没有根节点
		{
			this.root = newNode;//将第一个节点设置成根节点
		}
		else//不是根节点，放到最后一个节点之后
		{
			this.root.add(newNode);//通过Node自动安排此节点放的位置
		}
	}
	public void printNode()// 输出全部链表的内容
	{
		if(this.root != null)//如果根元素不为空
		{
			this.root.print();//调用Node类中的输出操作
		}
	}
	
	public boolean look(String name)//判断元素是否存在
	{
		return this.root.search(name);//调用Node类中的查找方法
	}
	public void deleteNode(String data)//删除节点
	{
		if(this.look(data))//判断节点是否存在
		{
			//一定要判断此元素是不是根元素相等的//
			if(this.root.data.equals(data))//内容是根节点
			{
				this.root = this.root.next;//修改根节点，将第一个节点设置为根节点
			}
			else
			{
				this.root.next.delete(root,data);//把下一个节点的前节点和数据一起出入进去
			}
		}
	}
};


public class JavaListPro11
{

	public static void main(String[] args)
	{
		LinkNew lin = new LinkNew();
		lin.addNode("A");//增加节点
		lin.addNode("B");//增加节点
		lin.addNode("C");//增加节点
		lin.addNode("D");//增加节点
		lin.addNode("E");//增加节点
		
		System.out.println("=====增加之后的内容======");
		lin.printNode();
		
		System.out.println(" ");
		System.out.println("=====尝试查找内容：C======");
		System.out.println(lin.look("C"));//查到返回true
		System.out.println(lin.look("X"));//查不到返回 false
		
		System.out.println(" ");
		System.out.println("=====删除之后======");
		lin.deleteNode("C");//删除已存在的节点
		lin.deleteNode("A");//删除根节点
		lin.deleteNode("R");//删除不存在的节点
		lin.printNode();

	}

}
