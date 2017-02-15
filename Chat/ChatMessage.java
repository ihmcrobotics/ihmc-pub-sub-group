package Chat;

/**
 * Generated from IDL struct "ChatMessage".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at Feb 14, 2017 2:29:54 PM
 */

public final class ChatMessage
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public ChatMessage(){}
	public java.lang.String sender = "";
	public java.lang.String msg = "";
	public ChatMessage(java.lang.String sender, java.lang.String msg)
	{
		this.sender = sender;
		this.msg = msg;
	}
}
