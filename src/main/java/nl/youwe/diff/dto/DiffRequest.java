package nl.youwe.diff.dto;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import org.hibernate.validator.constraints.NotBlank;

public class DiffRequest {

    @NotBlank
    private String original;

    @NotBlank
    private String revised;

    private boolean checkLines = true;

    private Boolean cleanupSemantic = false;

    private Boolean cleanupSemanticLossless = false;

    private float timeout = 0.0f;

    public DiffRequest() {
    }

    public String getOriginal() {
        return original;
    }

    public String getRevised() {
        return revised;
    }

    public boolean isCheckLines() {
        return checkLines;
    }

    public Boolean getCleanupSemantic() {
        return cleanupSemantic;
    }

    public Boolean getCleanupSemanticLossless() {
        return cleanupSemanticLossless;
    }

    public float getTimeout() {
        return timeout;
    }
}
