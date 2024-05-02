package br.com.sicro.firstplugin.commands;

import jdk.tools.jlink.internal.Platform;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FirstCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String aliases, String[] args) {

            if (!(commandSender instanceof Player)) return false;

            Player player = (Player) commandSender;

            String mensagemErro = ChatColor.RED + "Utilize: /curar <Player> <Quantidade>";

            if (command.getName().equalsIgnoreCase("curar")) {

                if (args.length != 2) {
                    player.sendMessage(mensagemErro);
                    return true;
                }

                Player target = Bukkit.getServer().getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "O jogador especificado não está online.");
                    return true;
                }

                int quantity;
                try {
                    quantity = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Por favor, insira uma quantidade válida.");
                    return true;
                }

                if (quantity > 20) {
                    player.sendMessage(ChatColor.RED + "Digite um número abaixo de 20.");
                    return true;
                } else if (quantity <= 0) {
                    player.sendMessage(ChatColor.RED + "Digite um número maior que 0.");
                    return true;
                }

                double currentHealth = target.getHealth();
                double maxHealth = target.getMaxHealth();

                if (currentHealth >= maxHealth) {
                    player.sendMessage(ChatColor.RED + "O jogador já está com a vida cheia.");
                    return true;
                }

                if (currentHealth + quantity > maxHealth) {
                    player.sendMessage(ChatColor.RED + "A cura excede a quantidade máxima de vida do jogador.");
                    return true;
                }

                target.setHealth(target.getHealth() + quantity);
                target.sendMessage(ChatColor.GREEN + "Você curou " + quantity + " corações.");
                player.sendMessage(ChatColor.GREEN + "Você curou " + target.getName() + " em " + quantity + " corações.");


                return true;
            }

            return false;
        }

    // plugin feito por pedrinpvp_YT
    }

