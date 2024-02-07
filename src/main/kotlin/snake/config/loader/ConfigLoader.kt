package snake.config.loader

import com.google.gson.Gson
import snake.config.GameConfig
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets.UTF_8

object ConfigLoader {
    private const val CONFIG_FILE = "/config.json"

    fun load(): GameConfig {
        val gson = Gson()

        return ConfigLoader::class.java.getResourceAsStream(CONFIG_FILE)
            ?.use { resource ->
                InputStreamReader(resource, UTF_8).use { reader ->
                    gson.fromJson(reader, GameConfig::class.java)
                }
            }
            ?: throw IllegalStateException("File not found: $CONFIG_FILE")
    }
}
