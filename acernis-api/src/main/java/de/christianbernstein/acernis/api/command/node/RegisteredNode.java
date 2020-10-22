package de.christianbernstein.acernis.api.command.node;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.Set;

/**
 * @author Christian Bernstein
 */
@Builder
@Data
public class RegisteredNode implements IRegisteredNode {

    @NonNull
    private final INode node;

    @NonNull
    private final Set<String> stringNodes;

    @Singular(value = "child")
    private final Set<RegisteredNode> childNodes;

    @Override
    public boolean test(String s) {
        return this.node.getLiteral().equals(s) || this.node.getAliases().contains(s);
    }
}