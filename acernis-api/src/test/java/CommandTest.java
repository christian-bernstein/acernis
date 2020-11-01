import de.christianbernstein.acernis.command.node.INode;
import de.christianbernstein.acernis.command.node.Node;
import de.christianbernstein.acernis.command.node.NodeDeclaration;

/**
 * @author Christian Bernstein
 */
public class CommandTest {

    // Parameter-optimistic node
    @NodeDeclaration
    public static final INode echoNode = Node.builder()
        .literal("echo")
        .executor(context -> System.out.println("" + context.getParameters().get("message")))
        .build();

}
