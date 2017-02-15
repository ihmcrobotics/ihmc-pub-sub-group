package Chat;


/**
 * Generated from IDL struct "ChatMessage".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at Feb 14, 2017 2:29:54 PM
 */

public abstract class ChatMessageHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(ChatMessageHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(Chat.ChatMessageHelper.id(),"ChatMessage",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("sender", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("msg", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final Chat.ChatMessage s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static Chat.ChatMessage extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:Chat/ChatMessage:1.0";
	}
	public static Chat.ChatMessage read (final org.omg.CORBA.portable.InputStream in)
	{
		Chat.ChatMessage result = new Chat.ChatMessage();
		result.sender=in.read_string();
		result.msg=in.read_string();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final Chat.ChatMessage s)
	{
		java.lang.String tmpResult0 = s.sender;
out.write_string( tmpResult0 );
		java.lang.String tmpResult1 = s.msg;
out.write_string( tmpResult1 );
	}
}
