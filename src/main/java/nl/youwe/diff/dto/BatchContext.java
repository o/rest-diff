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

public class BatchContext extends Context {

    @NotBlank
    private String identifier;

    public BatchContext() {
    }

    public String getIdentifier() {
        return identifier;
    }
}
