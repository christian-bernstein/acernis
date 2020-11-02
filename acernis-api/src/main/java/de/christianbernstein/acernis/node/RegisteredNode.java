package de.christianbernstein.acernis.node;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;
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
    private final List<IRegisteredNode> childNodes;

    @Override
    public boolean test(String s) {
        return this.node.getLiteral().equals(s) || this.node.getAliases().contains(s);
    }

}