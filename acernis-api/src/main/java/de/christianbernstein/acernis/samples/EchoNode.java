package de.christianbernstein.acernis.samples;

import de.christianbernstein.acernis.command.node.INode;
import de.christianbernstein.acernis.command.node.Node;
import de.christianbernstein.acernis.command.node.NodeDeclaration;

public class EchoNode {

    @NodeDeclaration
    public static final INode echoNode = Node.builder()
            .literal("echo")
            .executor(context -> System.out.println("Echo ^^"))
            .build();

}
