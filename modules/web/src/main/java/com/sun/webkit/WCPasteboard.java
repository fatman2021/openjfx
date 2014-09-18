/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.webkit;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.webkit.graphics.WCImageFrame;

final class WCPasteboard {

    private final static Logger log = 
        Logger.getLogger(WCPasteboard.class.getName());

    private static native void initIDs();
    private static final Pasteboard pasteboard;

    static {
        initIDs();
        pasteboard = Utilities.getUtilities().createPasteboard();
    };

    private WCPasteboard() {
    }

    private static String getPlainText() {
        log.fine("getPlainText()");
        return pasteboard.getPlainText();
    }

    private static String getHtml() {
        log.fine("getHtml()");
        return pasteboard.getHtml();
    }

    private static void writePlainText(String text) {
        log.log(Level.FINE, "writePlainText(): text = {0}", new Object[] {text});
        pasteboard.writePlainText(text);
    }

    private static void writeSelection(boolean canSmartCopyOrDelete, String text, String html)
    {
        log.log(Level.FINE, "writeSelection(): canSmartCopyOrDelete = {0},\n text = \n{1}\n html=\n{2}",
                new Object[] {canSmartCopyOrDelete, text, html});
        pasteboard.writeSelection(canSmartCopyOrDelete, text, html);
    }

    private static void writeImage(WCImageFrame img) {
        log.log(Level.FINE, "writeImage(): img = {0}", new Object[] {img});
        pasteboard.writeImage(img);
    }

    private static void writeUrl(String url, String markup) {
        log.log(Level.FINE, "writeUrl(): url = {0}, markup = {1}",
                new Object[] {url, markup});
        pasteboard.writeUrl(url, markup);
    }
}