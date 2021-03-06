/*
 * This file is part of Saturn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015, Jamie Mansfield <https://github.com/jamierocks>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package uk.jamierocks.saturn.common.command;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import uk.jamierocks.saturn.api.command.CommandCallable;

import java.util.List;

public class MinecraftCommandCallable extends CommandBase {

    private final CommandCallable callable;
    private final String name;
    private final String[] aliases;

    public MinecraftCommandCallable(CommandCallable callable, String name, String[] aliases) {
        this.callable = callable;
        this.name = name;
        this.aliases = aliases;
    }

    @Override
    public String getCommandName() {
        return this.name;
    }

    @Override
    public List getCommandAliases() {
        return Lists.newArrayList(this.aliases);
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        String arguments = "";
        for (String a : args) {
            arguments = arguments.concat(a + " ");
        }
        this.callable.execute(new SaturnCommandSender(sender), arguments);
    }
}
