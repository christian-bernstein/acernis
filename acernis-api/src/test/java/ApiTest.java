import de.christianbernstein.acernis.command.CommandFramework;
import de.christianbernstein.acernis.command.node.INode;
import de.christianbernstein.acernis.command.node.ReflectionNodeSource;

/**
 * @author Christian Bernstein
 */
public class ApiTest {

    private static final CommandFramework framework = CommandFramework.builder().build();

    public static void main(String[] args) {
        ReflectionNodeSource.builder().targetNodeClass(INode.class).build().get();
    }

}
