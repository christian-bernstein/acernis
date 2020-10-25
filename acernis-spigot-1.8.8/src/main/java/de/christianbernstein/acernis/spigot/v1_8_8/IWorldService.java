package de.christianbernstein.acernis.spigot.v1_8_8;

import org.bukkit.World;
import org.bukkit.WorldType;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Christian Bernstein
 */
public interface IWorldService {

    void createWorld(String worldName, World.Environment environment, WorldType type, String generatorSettings);

    Optional<World> getWorldReference(UUID worldID);

    void unloadWorld(UUID worldID);

}
