package de.christianbernstein.acernis.node;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Retrieve the nodes at runtime, with reflections. This source is based around the {@link org.reflections.Reflections} library.
 *
 * @author Christian Bernstein
 */
@Builder
public class ReflectionObjectHolderNodeSource implements INodeSource {

    /**
     * Stores the packages, which will be utilized for searching nodes.
     * If empty, {@link org.reflections.Reflections} will look through each package
     */
    @Singular(value = "pack")
    @NonNull
    private final List<String> packages;

    @NonNull
    private final Class<? extends INode> targetNodeClass;

    @Override
    public List<INode> get() {
        final List<URL> urls = new ArrayList<>();
        this.packages.forEach(pack -> urls.addAll(ClasspathHelper.forPackage(pack)));
        final Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(urls).setScanners(new SubTypesScanner(false)));
        final Set<Class<?>> types = reflections.getSubTypesOf(Object.class);
        final List<INode> nodes = new ArrayList<>();
        for (final Class<?> aClass : types) {
            final Field[] fields = aClass.getDeclaredFields().clone();
            for (final Field field : fields) {
                // Assert if the fields are valid nodes
                if (!field.getType().equals(this.targetNodeClass)){
                    continue;
                }
                if (!field.isAnnotationPresent(NodeDeclaration.class)){
                    continue;
                }
                // Check the node clashes with a already registered node



                // Construct the holder class


                // Construct the nodes
            }

        }
        return nodes;
    }
}
