package nl.youwe.diff.dto;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import javax.validation.constraints.NotNull;

public class Options {

    @NotNull
    private boolean checkLines = true;

    @NotNull
    private Boolean cleanupSemantic = false;

    @NotNull
    private float timeout = 0.0f;

    public Options() {
    }

    public boolean isCheckLines() {
        return checkLines;
    }

    public Boolean getCleanupSemantic() {
        return cleanupSemantic;
    }

    public float getTimeout() {
        return timeout;
    }
}
