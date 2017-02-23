package us.ihmc.idl.generator;

import java.io.IOException;

import org.anarres.cpp.LexerException;
import org.anarres.cpp.Preprocessor;
import org.anarres.cpp.Token;

/**
 * Helper class the replace tokens to the format IDLParser expects.
 * 
 * Replaces #line with #.
 * 
 * @author Jesper Smith
 *
 */
public class PreprocessorFilter extends Preprocessor
{
   @Override
   public Token token() throws IOException, LexerException
   {
      Token next = super.token();
      if(next != null && next.getType() == Token.P_LINE)
      {
         next = new Token(Token.P_LINE, next.getLine(), next.getColumn(), next.getText().replaceFirst("#line", "#"));
      }
      
      return next;
   }
}
