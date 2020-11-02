import de.christianbernstein.acernis.command.CommandFramework;
import de.christianbernstein.acernis.command.node.INode;
import de.christianbernstein.acernis.command.node.ReflectionObjectHolderNodeSource;

/**
 * @author Christian Bernstein
 */
public class ApiTest {

    private static final CommandFramework framework = CommandFramework.builder().build();

    public static void main(String[] args) {
        ReflectionObjectHolderNodeSource.builder().targetNodeClass(INode.class).pack("de.christianbernstein.acernis.samples").build().get();
    }

}
