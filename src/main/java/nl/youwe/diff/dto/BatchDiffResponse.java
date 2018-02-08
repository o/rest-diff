package nl.youwe.diff.dto;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import name.fraser.neil.plaintext.diff_match_patch;

import java.util.LinkedList;

public class BatchDiffResponse {

    private String identifier;

    private LinkedList<diff_match_patch.Diff> difference;

    public BatchDiffResponse(String identifier, LinkedList<diff_match_patch.Diff> difference) {
        this.identifier = identifier;
        this.difference = difference;
    }

    public String getIdentifier() {
        return identifier;
    }

    public LinkedList<diff_match_patch.Diff> getDifference() {
        return difference;
    }
}
