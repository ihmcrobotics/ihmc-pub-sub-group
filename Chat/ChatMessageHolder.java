package Chat;

/**
 * Generated from IDL struct "ChatMessage".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at Feb 14, 2017 2:29:54 PM
 */

public final class ChatMessageHolder
	implements org.omg.CORBA.portable.Streamable
{
	public Chat.ChatMessage value;

	public ChatMessageHolder ()
	{
	}
	public ChatMessageHolder(final Chat.ChatMessage initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return Chat.ChatMessageHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = Chat.ChatMessageHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		Chat.ChatMessageHelper.write(_out, value);
	}
}
